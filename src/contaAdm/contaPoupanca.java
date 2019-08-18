/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contaAdm;

/**
 *
 * @author Gaba
 */
public class contaPoupanca extends conta {
     public void rendimento(double sal)
    {
        double bruto = 0;
        bruto = sal * 0.1;
        saldo = (int) (saldo + bruto);
    }
}
