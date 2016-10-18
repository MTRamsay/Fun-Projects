/**
 * Matthew Ramsay
 * N00943512
 */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Timers;

namespace CountdownTimer
{
    class CustomTimer
    {
        Timer timer1;
        int duration;
        public CustomTimer(int tickRate)
        {
            timer1 = new Timer(tickRate);
            Console.WriteLine("\nYou've just created a timer!\n");
            timer1.Elapsed += new ElapsedEventHandler(MyTimer_Elapsed);
        } // end Constructor
        private void MyTimer_Elapsed(object sender, ElapsedEventArgs e)
        {
            if (duration >= 0)
            {
                ClearCurrentConsoleLine();
                if (duration >= 25)
                    Console.ForegroundColor = ConsoleColor.Blue;
                else if (duration >= 20)
                    Console.ForegroundColor = ConsoleColor.Cyan;
                else if (duration >= 15)
                    Console.ForegroundColor = ConsoleColor.DarkGray;
                else if (duration >= 10)
                    Console.ForegroundColor = ConsoleColor.DarkRed;
                else if (duration >= 5)
                    Console.ForegroundColor = ConsoleColor.Yellow;
                else
                    Console.ForegroundColor = ConsoleColor.Magenta;

                Console.Write("{0}", duration);
                duration--;
            } // end if
            else
                StopMyTimer();
        } // end  MyTimer_Elapsed()
        private void StopMyTimer()
        {
            timer1.Stop();
            Console.WriteLine("\n\nYour time is up!!!");
        } // end StopMyTimer()
        public void StartMyTimer(int newDuration)
        {
            duration = newDuration;
            Console.WriteLine("\n\nCounting down from {0}!\n", duration);
            timer1.Start();
        } // end StartMyTimer()
        private void ClearCurrentConsoleLine()
        {
            int currentLineCursor = Console.CursorTop;
            Console.SetCursorPosition(0, Console.CursorTop);
            Console.Write(new string(' ', Console.WindowWidth));
            Console.SetCursorPosition(0, currentLineCursor);
        } // end ClearCurrentConsoleLine()
    } // end custom timer class
} // end namespace
