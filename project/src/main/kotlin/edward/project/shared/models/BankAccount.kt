package edward.project.shared.models

data class BankAccount(
    val acctType: String,
    val acctName: String,
    val acctAlias: String,
    val availableBalance: Double,
)
