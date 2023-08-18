package starterPackage;

abstract class BankCard { // Класс банковская карта
    private int balance; // свойство баланс
    private int bonus; // свойство бонус

    public BankCard(int primaryBalance) {
        this.balance = primaryBalance;
    }

    protected synchronized void topUp(int amount){ // функция "пополнить"
        if (amount > 0){
            this.balance += amount;
        }
    }

    protected synchronized void pay(int amount){ // функция "оплатить"
        if (amount > 0 && amount <= this.balance){
            this.balance -= amount;
        }
    }

    protected void infoBalance() { // функция "получить информацию о балансе"
        System.out.println("Собственные средства: "+balance);
    }

    protected int getBalance() { // функция "получить баланс"
        return balance;
    } // функция "получить баланс"

    private void addBonus(int amount){ // функция "добавить бонусы"
        this.bonus += amount;
    } // функция "добавить бонусы"

    private void spendBonus(int amount){ // функция "списать бонусы"
        this.bonus -= amount;
    } // функция "списать бонусы"
    protected int getBonus(){
        return bonus;
    }// функция "получить бонусы"

    protected int useBonus(int amount, boolean useBonus, double percentBonus){
        int writeOFF=1; // переменная, в которую передается сумма списания со счета
        if (useBonus){ // узнаем собирается ли человек списывать бонусы
            if (amount > getBonus()){ // узнаем сумма покупки больше колличества бонусов или нет
                int remainder = amount - getBonus(); // если да, то узнаем сколько необходимо списать средств
                writeOFF = remainder; // записываем какую сумму необходимо списать
                spendBonus(getBonus()); // списываем все бонусы в счет покупки
                addBonus((int) Math.round(remainder*percentBonus)); // начисляем 1% от покупки(со списанных средств)
            } else { // если бонусов больше, чем сумма покупки то
                int spentBonus = getBonus() - amount+1; // узнаем разницу между суммой покупки и бонусов
                spendBonus(spentBonus); // списываем бонусы
            }
        } else {
            writeOFF=amount;// если человек не хочет списывать бонусы, то списываем всю сумму покупки
            addBonus((int) Math.round(amount*percentBonus)); // начисляем 1% бонусов
        }
        return writeOFF; // возвращаем сумму, которую необходимо списать
    }
}
