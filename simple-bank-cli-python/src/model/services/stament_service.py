from model.domain.user import User
from model.domain.transaction import Transaction

class Statement:
    def __init__(self, user, list_transcation):
        self.user = user
        self.list = list_transcation

class StatementService:

    def __init__(self, transaction_repository):
        self.transaction_repository = transaction_repository
    
    def find_transacations_by_user(self, user) -> list:
        transactions = self.transaction_repository.find_by_user_sorce_email(user.email)
        return Statement(user, transactions)
