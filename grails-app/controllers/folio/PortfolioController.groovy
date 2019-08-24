package folio

import org.example.User

class PortfolioController {

    static scaffold = Portfolio

    def folio () {
        User user = User.findByUsername(params.id)
        respond user ? user : null
    }

}
