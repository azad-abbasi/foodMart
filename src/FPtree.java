import java.util.*;

public class FPtree
{
    public static void main(String x[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Ebter no of trans");
        int no_t=sc.nextInt();
        System.out.println("Enter no_itemset");
        int no_i=sc.nextInt();
        System.out.println("Enter min support");
        int min_sup=sc.nextInt();
        System.out.println("Enter 0 afer entering one transaction");
        String d[][][]=new String [no_t][2][no_i];
        for(int i=0;i<no_t;i++)
        {
            System.out.println("TID no:"+(i+1));
            for(int k=0;k<no_i;k++)
            {
                String s=sc.next();
                d[i][1][k]=s;
                if(d[i][1][k].equals("0"))
                {
                    break;
                }
            }
        }
        char item_set[]=new char[no_i];
        System.out.println("itemset:");
        for(int i=0;i<item_set.length;i++)
        {
            item_set[i]=(char)(i+97);
            System.out.println(" " +item_set[i]);
        }
        int sup[]=new int[item_set.length];
        int s=0;
        System.out.println("correspon supports");
        for(int j=0;j<sup.length;j++)
        {
            s=0;
            for(int i=0;i<no_t;i++)
            {
                for(int k=0;k<no_i;k++)
                {
                    if(d[i][1][k].equals("0"))
                    {
                        break;
                    }
                    if((d[i][1][k].charAt(0))==(item_set[j]))
                    {
                        s++;
                        sup[j]=s;
                    }
                }
            }
            System.out.println("  "+sup[j]);
        }

        char itemset_new[]=new char[item_set.length];
        int count=0;
        for(int k=0;k<sup.length;k++)         {             if(sup[k]>=min_sup)
        {
            itemset_new[k]=item_set[k];
            count++;
        }
        }
        System.out.println("");
        for(int i=0;i<sup.length;i++)
        {
            for(int j=0;j<sup.length-1;j++)
            {
                if(sup[j]<sup[j+1])
                {
                    int temp=sup[j];
                    sup[j]=sup[j+1];
                    sup[j+1]=temp;
                    char temp1=itemset_new[j];
                    itemset_new[j]=itemset_new[j+1];
                    itemset_new[j+1]=temp1;
                }
            }
        }

        char is_final[]=new char[count];
        int sup_final[]=new int[count];
        int cnt=0;
        for(int i=0;i<no_i;i++)
        {
            if(Character.isLetter(itemset_new[i]))
            {
                is_final[cnt]=itemset_new[i];
                sup_final[cnt]=sup[i];
                cnt++;
            }
        }
        for(int i=0;i<is_final.length;i++)
        {
            System.out.print(is_final[i]+"\t"+sup_final[i]);
        }

        for(int i=0;i<no_t;i++)
        {
            System.out.println("Transactiom No:"+(i+1));
            System.out.println("ROOT");
            for(int m=0;m<count;m++)
            {

                for(int k=0;k<no_i;k++)                 {                     if(d[i][1][k].equals("0"))                     {                         break;                     }                     if((d[i][1][k].charAt(0))==(is_final[m]) && (sup_final[m])>0)
                {
                    System.out.print("\n|\n"+is_final[m]);
                    sup_final[m]--;
                    break;
                }
                }

            }
            System.out.println("\n\n");
        }
    }
}