from src.model.domain.transaction import Transaction

class WithdrawMoneyController:

    def __init__(self, withdraw_service, select_user_controller, find_user_service, view):
        self.select_user_controller = select_user_controller
        self.find_user_service = find_user_service
        self.service = withdraw_service
        self.view = view

    def process(self):
        users = self.find_user_service.find_all()

        self.select_user_controller.print_main()
        self.select_user_controller.print_user(users)

        # TODO: refact to pass the transaction object!

        user_source, user_target = self.set_users(users)
        value = float(input('Value: '))

        transaction = Transaction(value, user_source, user_target)
        self.service.add(transaction)

    def set_users(self, users):
        self.select_user_controller.print_select_user_custom('Select user source: ')
        user_source = users[self.select_user_controller.get_opt()]

        self.select_user_controller.print_select_user_custom('Select user target: ')
        user_target = users[self.select_user_controller.get_opt()]

        return user_source, user_target

    def get_description(self):
        return 'Withdraw money(Sacar)'

class WithdrawMoneyView:
    
    def __init__(self):
        pass

class TransactionService:

    def __init__(self, transaction_repository):
        self.transactions = list()
        self.transaction_repository = transaction_repository

    def add(self, transaction):
        self.transaction_repository.add(transaction)
