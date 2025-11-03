from src.model.domain.wallet import Wallet

class User:
    
    def __init__(self, name, email, current_value):
        self.name = name
        self.email = email
        self.wallet = Wallet(current_value)

    def validate(self) -> bool:

        if self.name.strip() == '':
            return False

        if self.email.strip() == '':
            return False
        
        if self.wallet.get_value() == None:
            return False;

        return True

