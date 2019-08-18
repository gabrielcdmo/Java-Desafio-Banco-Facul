
package caixaeletronica;

import java.util.ArrayList;
import java.util.Scanner;              
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;



import contaAdm.contaPoupanca;
import contaAdm.contaCorrente;




public class Mapa {

    public static void main(String[] args) throws IOException, UnknownHostException {
        ArrayList<contaPoupanca> listaPoupanca = new ArrayList<>();
        ArrayList<contaCorrente> listaCorrente = new ArrayList<>();
        
        contaPoupanca cp1 = new contaPoupanca();     
        contaPoupanca cp2 = new contaPoupanca();
        contaCorrente cc1 = new contaCorrente();
        contaCorrente cc2 = new contaCorrente();
        
        listaPoupanca.add(cp1);
        listaPoupanca.add(cp2);
        listaCorrente.add(cc1);
        listaCorrente.add(cc2);
        
        for(int i = 0; i < listaPoupanca.size(); i++)
        {
            int n = 1000;
            n = n + i;
            listaPoupanca.get(i).setNumero(n);
            n = 0;
            n = n + i;
            listaPoupanca.get(i).setDigito(i);
            n = 100;
            n = n + i;
            listaPoupanca.get(i).setAgencia(n);
        }
        
        for(int i = 0; i < listaCorrente.size(); i++)
        {
            int n = 2000;
            n = n + i;
            listaCorrente.get(i).setNumero(n);
            n = 0;
            n = n + i;
            listaCorrente.get(i).setDigito(i);
            n = 100;
            n = n + i;
            listaCorrente.get(i).setAgencia(n);
        }
               
        String namePC = InetAddress.getLocalHost().getHostName();
        int rsp = 0;
        Scanner resp = new Scanner(System.in);
        int opc = 0;
        Scanner opcao = new Scanner(System.in);
        int nc = 0;
        Scanner numc = new Scanner(System.in);
        int acha = 0;
        int acha_gen = 0;
        double r$ = 0;
        Scanner money = new Scanner(System.in);
        int sucesso = 0;
       

       
        do
        {
            acha_gen = 0;
            System.out.println("Olá " + namePC + ", bem vindo!");
            System.out.println("Tecle 1 - Para exibir contas criadas");
            System.out.println("Tecle 2 - Para gerenciar uma conta!");
            opc = opcao.nextInt();
            switch(opc)
            {
                case 1:
                    System.out.println("Contas poupanças: ");
                    for(int i = 0; i < listaPoupanca.size(); i++)
                    {
                        int o = i + 1;
                        System.out.println(o + "- Numero: " + listaPoupanca.get(i).getNumero() + ", Digito: " + listaPoupanca.get(i).getDigito() + ", Agência " + listaPoupanca.get(i).getAgencia());
                    }
                    System.out.println("Contas correntes: ");
                    for(int i = 0; i < listaCorrente.size(); i++)
                    {
                        int o = i + 1;
                        System.out.println(o + "- Numero: " + listaCorrente.get(i).getNumero() + ", Digito: " + listaCorrente.get(i).getDigito() + ", Agência " + listaCorrente.get(i).getAgencia());
                    }
                    break;
                
                case 2:
                    System.out.println("Digite o número da conta: ");
                    nc = numc.nextInt();
                    //
                        for(int i = 0; i < listaPoupanca.size(); i++)
                        {
                            if(listaPoupanca.get(i).getNumero() == nc)
                            {
                                acha_gen = 1;
                                do
                                {
                                    System.out.println("Conta: " + listaPoupanca.get(i).getNumero() + ", Saldo: R$" +listaPoupanca.get(i).getSaldo());
                                    System.out.println("Tecle: ");
                                    System.out.println("1 - Para saques");
                                    System.out.println("2 - Para depósitos");
                                    System.out.println("3 - Para transferências");
                                    opc = opcao.nextInt();
                                    switch(opc)
                                    {
                                        case 1:
                                            System.out.println("Digite o valor do saque");
                                            r$ = money.nextDouble();
                                            System.out.println(listaPoupanca.get(i).saque(r$));
                                            break;
                                            
                                        case 2:
                                            System.out.println("Digite o valor do depósito");
                                            r$ = money.nextDouble();
                                            listaPoupanca.get(i).deposito(r$);
                                            listaPoupanca.get(i).rendimento(r$);
                                            break;
                                        case 3:
                                            do
                                            {
                                                sucesso = 0;
                                                acha = 0;
                                                System.out.println("Digite a conta destinatária");
                                                nc = numc.nextInt();
                                                System.out.println("Digite o valor");
                                                r$ = money.nextInt();
                                                if(acha != 1)
                                                {
                                                    for(int u = 0; u < listaPoupanca.size(); u++)
                                                    {
                                                        if(listaPoupanca.get(u).getNumero() == nc)
                                                        {
                                                            
                                                            sucesso = listaPoupanca.get(i).transfere(r$);
                                                            if(sucesso == 1)
                                                            {
                                                                listaPoupanca.get(u).deposito(r$);
                                                            }
                                                            acha = 1;
                                                        }
                                                    }
                                                    if(acha != 1){
                                                        for(int o = 0; o < listaCorrente.size(); o++)
                                                        {
                                                            if(listaCorrente.get(o).getNumero() == nc)
                                                            {
                                                                sucesso = listaPoupanca.get(i).transfere(r$);
                                                                if(sucesso == 1)
                                                                {
                                                                    listaCorrente.get(o).deposito(r$);
                                                                }
                                                                acha = 1;
                                                                System.out.println("Novo saldo: " + "R$ " + listaPoupanca.get(i).getSaldo());
                                                                break;
                                                            }
                                                        }
                                                        if(acha == 0)
                                                        {
                                                            System.out.println("Não foi possível encontrar esta conta");
                                                        }
                                                    }
                                                }
                                                
                                                System.out.println("Pressione 1 para uma nova transferência");
                                                rsp = resp.nextInt();
                                            }while(rsp == 1);
                                            break;
                                        default:
                                                System.out.println("OPÇÃO INVÁLIDA!");
                                            break;
                                    }
                                    
                                    System.out.println("Deseja continuar no gerenciamento? Se sim tecle 1");
                                    rsp = resp.nextInt();
                                }while(rsp == 1);
                                break;
                            }
                        }
                        for(int i = 0; i < listaCorrente.size(); i++)
                        {
                            if(listaCorrente.get(i).getNumero() == nc)
                            {
                                do
                                {
                                    acha_gen = 1;
                                    System.out.println("Conta: " + listaCorrente.get(i).getNumero() + ", Saldo: R$" +listaCorrente.get(i).getSaldo() + ", Saldo limite: R$" + listaCorrente.get(i).getLimiteConta());
                                    System.out.println("Tecle: ");
                                    System.out.println("1 - Para saques");
                                    System.out.println("2 - Para depósitos");
                                    System.out.println("3 - Para transferências");
                                    opc = opcao.nextInt();
                                    switch(opc)
                                    {
                                        case 1:
                                            System.out.println("Digite o valor do saque");
                                            r$ = money.nextDouble();
                                            System.out.println(listaCorrente.get(i).saque(r$));
                                            break;
                                            
                                        case 2:
                                            System.out.println("Digite o valor do depósito");
                                            r$ = money.nextDouble();
                                            listaCorrente.get(i).deposito(r$);
                                            break;
                                        case 3:
                                            do
                                            {
                                                sucesso = 0;
                                                acha = 0;
                                                System.out.println("Digite a conta destinatária");
                                                nc = numc.nextInt();
                                                System.out.println("Digite o valor");
                                                r$ = money.nextInt();
                                                if(acha != 1)
                                                {
                                                    for(int u = 0; u < listaPoupanca.size(); u++)
                                                    {
                                                        if(listaPoupanca.get(u).getNumero() == nc)
                                                        {
                                                            
                                                            sucesso = listaCorrente.get(i).transfere(r$);
                                                            if(sucesso == 1)
                                                            {
                                                                listaPoupanca.get(u).deposito(r$);
                                                            }
                                                            acha = 1;
                                                            System.out.println("Saldo atual: " + "R$ " + listaCorrente.get(i).getSaldo() + ", Saldo limite atual: R$ " +listaCorrente.get(i).getLimiteConta());
                                                        }
                                                    }
                                                    if(acha != 1){
                                                        for(int o = 0; o < listaCorrente.size(); o++)
                                                        {
                                                            if(listaCorrente.get(o).getNumero() == nc)
                                                            {
                                                                sucesso = listaCorrente.get(i).transfere(r$);
                                                                if(sucesso == 1)
                                                                {
                                                                    listaCorrente.get(o).deposito(r$);
                                                                }
                                                                acha = 1;
                                                                System.out.println("Saldo atual: " + "R$ " + listaCorrente.get(i).getSaldo() + ", Saldo limite atual: R$ " +listaCorrente.get(i).getLimiteConta());
                                                                break;
                                                            }
                                                        }
                                                        if(acha == 0)
                                                        {
                                                             System.out.println("Não foi possível encontrar esta conta");
                                                        }
                                                    }
                                                }  
                                                System.out.println("Pressione 1 para uma nova transferência");
                                                rsp = resp.nextInt();
                                            }while(rsp == 1);
                                            break;
                                        default:
                                                System.out.println("OPÇÃO INVÁLIDA!");
                                            break;
                                    }
                                    
                                    System.out.println("Deseja continuar no gerenciamento? Se sim tecle 1");
                                    rsp = resp.nextInt();
                                }while(rsp == 1);
                                break;
                            }
                        }
                    //
                        if(acha_gen == 0)
                        {
                            System.out.println("Não foi possível encontrar sua conta, tente novamente!");
                        }
                    break;
            }
            System.out.println("Para retornar ao menu digite 1");
            rsp = resp.nextInt();
        }while(rsp == 1);
        
    }
}
