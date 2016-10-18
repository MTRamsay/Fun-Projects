/**
 * Matthew Ramsay
 * N00943512
 */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CountdownTimer
{
    class Program
    {
        static void Main(string[] args)
        {
            CustomTimer timer1 = new CustomTimer(1000);
            timer1.StartMyTimer(25);

            Console.ReadLine();
        } // end main method
    } // end class program

} // end NameSpace
