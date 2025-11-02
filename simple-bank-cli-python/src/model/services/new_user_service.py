from src.model.exception import UserExistsError, UserInvalidError

class NewUserService:

    def __init__(self, user_repository):
        self.repository = user_repository

    def add(self, user):
        self.validate_user(user)
        self.repository.add(user)

    def validate_user(self, user) -> None:
        raise(UserInvalidError, 'User with fields invalid')
        

    def validate_user_exists(self, user) -> bool:
        raise(UserExistsError, f'Already exists an user with this email: ${user.email}')

