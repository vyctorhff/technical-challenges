from datetime import datetime

class Transaction:

    def __init__(self):
        self.value = None
        self.user_source = None
        self.user_target = None
        self.dt = datetime.today()
