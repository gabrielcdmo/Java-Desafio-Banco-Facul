/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contaAdm;


public abstract class conta {
    protected int agencia;
    protected int numero;
    protected int digito;
    protected double saldo;
    
    
    public void setAgencia(int num)
    {
        this.agencia = num;
    }
    public int getAgencia()
    {
        return this.agencia;
    }
    
    public void setNumero(int num)
    {
        this.numero = num;
    }
    public int getNumero()
    {
        return this.numero;
    }
    
    public void setDigito(int num)
    {
        this.digito = num;
    }
    public int getDigito()
    {
        return this.digito;
    }
    
    public double getSaldo()
    {
        return this.saldo;
    }
    
    public void deposito(double num)
    {
        if(num > 0)
        {
            this.saldo = this.saldo + num;
        }
    }
    
    public String saque(double value)
    {
        String status = "";
        if(value != 0 && saldo >= value)
        {
            saldo = saldo - value;
            status = "Saque efetuado com sucesso, aguarde a contagem de notas";
        }
        else
        {
            status = "Não foi possível realizar o saque!";
        }
        return status;
    }
    
    public int transfere(double value)
    {
        int status = 0;
        if(saldo >= value)
        {
            this.saldo = saldo - value;
            System.out.println("Transferência bem sucedida");
            status = 1;
        }
        else
        {
            System.out.println("Saldo insuficiente");
            status = 0;
        }
        return status;
    }
    
    public conta(){
        this.agencia = 0;
        this.numero = 0;
        this.digito = 0;
        this.saldo = 200;
    }
    
    
}
