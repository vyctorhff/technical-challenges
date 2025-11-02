class Wallet:

    def __init__(self, current_value):
        self.current_value = current_value
        self.check_not_negative()

    def debit(self, value):
        pass

    def credit(self, value):
        pass

    def check_not_negative(self):
        if (self.current_value < 0.0):
            raise(ValueError, 'Current value invalid')
