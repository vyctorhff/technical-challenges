from src.view.messages import SELECT_USER_HAS_NO_USER, SELECT_USER, SELECT_USER_ITEM

class SelectUserController:

    def __init__(self, find_user_service):
        self.find_user_service = find_user_service

    def print_main(self):
        print(SELECT_USER)

    def print_user(self, users):
        if (len(users) == 0):
            print(SELECT_USER_HAS_NO_USER)
            return
        
        user_grid = ''
        for index, value in enumerate(users):
            user_grid += SELECT_USER_ITEM.format(index, value.name)
            if index % 3 == 0:
                user_grid += "\t"
                continue
            user_grid += "\n"
        
        print(user_grid)

    def print_select_user(self):
        self.opt = input(SELECT_USER)
    
    def print_select_user_custom(self, msg):
        self.opt = input(msg)
    
    def get_opt(self):
        return int(self.opt)

class SelectUserView:
    pass
