from src.controller.main_controller import MainController
from src.controller.user_controller import UserController
from src.controller.exit_controller import ExitController
from src.controller.money_controller import MoneyController
from src.controller.statment_controller import StatementController

from src.view.new_user_view import NewUserView
from src.view.menu_view import MenuView
from src.view.stament_view import StatmentView

from src.model.repository.transaction_in_memory_repository import TransactionInMemoryRepository
from src.model.repository.user_in_memory_repository import UserInMemoryRepository

from src.model.services.new_user_service import NewUserService
from src.model.services.find_user_service import FindUserService
from src.model.services.stament_service import StatementService

controllers = [
    UserController(NewUserService, NewUserView),
    MoneyController(),
    StatementController(FindUserService(), TransactionInMemoryRepository(), StatmentView()),
    ExitController()
]
main_controller = MainController(MenuView(), controllers)

while (not main_controller.is_exit()):
    main_controller.process()
