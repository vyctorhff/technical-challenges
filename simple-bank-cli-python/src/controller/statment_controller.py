
class StatementController:

    def __init__(self, find_user_service, service, view):
        self.service = service
        self.find_user_service = find_user_service
        self.view = view

    def process(self):
        self.view.print_main()

        users = self.find_user_service.find_all()
        self.view.print_user(users)
        self.view.print_select_user()

        user = self.view.get_user()

        transactions = self.service.find_transacations_by_user(user)
        self.view.print_transaction(transactions)
    
    def get_description(self):
        return 'Stament(Extrato)'
