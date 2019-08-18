
package contaAdm;


public class contaCorrente extends conta{
      private double limiteconta = 1000;  
      
      public double getLimiteConta()
      {
          return this.limiteconta;
      }
      
     @Override 
      public String saque(double value)
     {
        String status = "";
        double temp = 0;
        double backup_saldo = this.saldo;
        double backup_limite = this.limiteconta;
        if(saldo < value && saldo != 0 && limiteconta != 0)
        {
            while(temp != value)
            {
                if(saldo > 0)
                {
                    saldo--;
                    temp++;
                }
                if(saldo == 0 && temp != value)
                {
                    limiteconta--;
                    temp++;
                }
                if(limiteconta == 0 && saldo == 0 && value != temp)
                {
                    status = "Não foi possível realizar seu saque, não há saldo em ambas partes!";
                    this.saldo = backup_saldo;
                    this.limiteconta = backup_limite;
                    break;
                }
            }
        }
        else if(saldo == 0 && limiteconta >= value)
        {
            this.limiteconta = this.limiteconta - value;
            status = "Saque utilizando limite efetuado com sucesso!";
        }
        else if(saldo >= value && value != 0)
        {
            this.saldo = this.saldo - value;
            status = "Saque utilizando saldo efetuado com sucesso!";
        }
        else
        {
            status = "Não foi possível realizar seu saque :(, tente novamente ou mais tarde rsrs";
        }
        return status;
    }
    
     @Override 
      public int transfere(double value)
    {
        int status = 0;
        double temp = 0;
        double backup_saldo = this.saldo;
        double backup_limite = this.limiteconta;
        if(saldo < value && saldo != 0 && limiteconta != 0)
        {
            while(temp != value)
            {
                if(saldo > 0)
                {
                    saldo--;
                    temp++;
                }
                if(saldo == 0 && temp != value)
                { 
                    limiteconta--;
                    temp++;
                }
                if(limiteconta == 0 && saldo == 0 && value != temp)
                {
                    System.out.println("Não foi possível realizar sua transferência!");
                    status = 0;
                    this.saldo = backup_saldo;
                    this.limiteconta = backup_limite;
                    break;
                }
            }
            if(temp == value)
            {
                System.out.println("Transferência realizada com sucesso!");
                 status = 1;
            }
        }
        else if(saldo == 0 && limiteconta >= value)
        {
            this.limiteconta = this.limiteconta - value;
            System.out.println("Transferência realizada com sucesso!");
             status = 1;
        }
        else if(saldo >= value && value != 0)
        {
            this.saldo = this.saldo - value;
            System.out.println("Transferência realizada com sucesso!");
             status = 1;
        }
        else
        {
            System.out.println("Não foi possível realizar seu saque :(, tente novamente ou mais tarde rsrs");
            status = 0;
        }
        return status;
    }
      
}
