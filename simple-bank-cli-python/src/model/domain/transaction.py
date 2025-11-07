from datetime import datetime

class Transaction:

    def __init__(self, value, user_source, user_target):
        self.value = value
        self.user_source = user_source
        self.user_target = user_target
        self.dt = datetime.today()

    def check_user_source_email(self, email) -> bool:
        return self.user_source.email == email
