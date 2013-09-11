class Account {
  val id = Account.newUniqueNumber()
  private var balance = 0.0

  def deposit(amount: Double) {
    balance += amount
  }
}

object Account {
  // The companion object
  private var lastNumber = 0

  private def newUniqueNumber() = {
    lastNumber += 1; lastNumber
  }
}