from src.controller.main_controller import MainController
from src.controller.user_controller import UserController
from src.controller.exit_controller import ExitController

from src.view.new_user_view import NewUserView
from src.view.menu_view import MenuView

from src.model.services.new_user_service import NewUserService

controllers = [
    UserController(NewUserService, NewUserView),
    ExitController()
]
main_controller = MainController(MenuView(), controllers)

while (not main_controller.is_exit()):
    main_controller.process()
