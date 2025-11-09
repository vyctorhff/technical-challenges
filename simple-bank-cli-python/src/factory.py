
from src.controller.main_controller import MainController
from src.controller.user_controller import UserController
from src.controller.exit_controller import ExitController
from src.controller.withdraw_controller import WithdrawMoneyController
from src.controller.statment_controller import StatementController
from src.controller.select_user_controller import SelectUserController

from src.view.menu_view import MenuView
from src.view.stament_view import StatmentView
from src.view.new_user_view import NewUserView

from src.model.repository.transaction_in_memory_repository import TransactionInMemoryRepository
from src.model.repository.user_in_memory_repository import UserInMemoryRepository

from src.controller.withdraw_controller import TransactionService, WithdrawMoneyController, WithdrawMoneyView
from src.model.services.stament_service import StatementService
from src.model.services.new_user_service import NewUserService
from src.model.services.find_user_service import FindUserService

# #######################################################################
# Factory

# user_repo = UserInMemoryRepository()
# transaction_repo = TransactionInMemoryRepository()

# new_user_service = NewUserService(user_repo)
# find_user_service = FindUserService(user_repo)
# statment_service = StatementService(transaction_repo)
# transaction_service = TransactionService(transaction_repo)

# select_user_controller = SelectUserController(find_user_service)
# statment_controller = StatementController(find_user_service, statment_service, StatmentView(), select_user_controller)
# withdraw_controller = WithdrawMoneyController(transaction_service, select_user_controller, find_user_service, WithdrawMoneyView())

class FactoryService:

    def __init__(self):
        self.user_repo = UserInMemoryRepository()
        self.transaction_repo = TransactionInMemoryRepository()

        self.new_user = NewUserService(self.user_repo)
        self.select_user = FindUserService(self.user_repo)
        self.statment = StatementService(self.transaction_repo)
        self.transaction = TransactionService(self.transaction_repo)

    def get_new_user_service(self) -> NewUserService:
        return self.new_user

    def get_select_user_service(self) -> FindUserService:
        return self.select_user
    
    def get_statement_service(self) -> StatementService:
        return self.statment

    def get_transaction_service(self) -> TransactionService:
        return self.transaction

class FactoryController:

    def __init__(self):
        self.factory_service = FactoryService()
    
    def create_main(self):
        controllers = [
            self.create_user(),
            self.create_withdraw(),
            self.create_statement(),
            self.create_exit()
        ]
        return MainController(MenuView(), controllers)

    def create_select_user(self):
        return SelectUserController(
            self.factory_service.get_new_user_service()
        )

    def create_statement(self):
        return StatementController(
            self.factory_service.get_select_user_service(),
            self.factory_service.get_statement_service(),
            StatmentView(),
            self.create_select_user()
        )

    def create_withdraw(self):
        return WithdrawMoneyController(
            self.factory_service.get_transaction_service(),
            self.create_select_user(),
            self.factory_service.get_select_user_service(),
            WithdrawMoneyView()
        )
    
    def create_user(self):
        return UserController(
            self.factory_service.get_new_user_service(),
            NewUserView()
        )
    
    def create_exit(self):
        return ExitController()
