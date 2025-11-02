from src.view import messages

class MainController:

    def __init__(self):
        self.option = 5
        self.controllers = tuple()
    
    def add_controller(self, controller):
        self.controllers.append(controller)

    def print_main(self):
        print(messages.MAIN)
        self.option = int(input(messages.SELECT))
    
    def is_exit(self) -> bool:
        return self.option == 5
