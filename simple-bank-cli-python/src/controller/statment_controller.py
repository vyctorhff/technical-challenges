
class StatementController:

    def __init__(self, find_user_service, service, view, select_user_controlller):
        self.service = service
        self.find_user_service = find_user_service
        self.view = view
        self.select_user_controlller = select_user_controlller

    def process(self):
        self.view.print_main()
        users = self.find_user_service.find_all()

        # TODO: refact to select_user_view
        # select_view.process(users)
        self.select_user_controlller.print_user(users)

        if (len(users) <= 0):
            return

        self.select_user_controlller.print_select_user()

        opt = self.select_user_controlller.get_opt()
        user = users[opt]

        stament = self.service.find_transacations_by_user(user)
        self.view.print_transaction(stament.list_transcation)
    
    def get_description(self):
        return 'Stament(Extrato)'
