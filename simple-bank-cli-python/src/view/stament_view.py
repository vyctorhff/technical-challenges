from src.view.messages import STAMENT_MAIN, STAMENT_TRANSACTION_DETAIL, STAMENT_NO_TRANSACTIONS

class StatmentView:

    def __init__(self):
        pass

    def print_main(self):
        print(STAMENT_MAIN)

    def print_transaction(self, transactions):
        if len(transactions) == 0:
            print(STAMENT_NO_TRANSACTIONS)
            return

        for transaction in transactions:
            date = transaction.dt
            value = transaction.value
            user = transaction.user_target.name
            print(STAMENT_TRANSACTION_DETAIL.format(user, value, date))
