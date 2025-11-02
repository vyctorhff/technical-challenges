from src.model.domain.wallet import Wallet

class User:
    
    def __init__(self, name, email, current_value):
        self.name = name
        self.email = email
        self.account = Wallet(current_value)

    def validate(self) -> bool:
        return False

