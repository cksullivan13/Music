using System;

using System.Windows;
using System.Windows.Controls;



namespace Music_Theory_Desktop
{
   
    public partial class MainWindow : Window
    {
        private ScaleWizard sw;

       



        //inputConverter isn't working properly. it seems to only return 0 no matter what the button press is



        private void Button_Click(object sender, RoutedEventArgs e)
        {
            var button = (Button)sender;
            var converted = sw.InputConverter(button);
            var rotated = sw.RotateLeft(sw.GetKeyboard(), converted);
            var printMaj = sw.MakeMajor(rotated);
            var printMin = sw.MakeMinor(rotated);
            var printHarm = sw.MakeHarmonic(rotated);
            var printPent = sw.MakePent(rotated);
            var printBlues = sw.MakeBlues(rotated);


           
                if ((bool)Maj.IsChecked)
                {
                    printout.Content = String.Join("  ", printMaj);
                }
                else if ((bool)Min.IsChecked)
                {
                    printout.Content = String.Join("  ", printMin);
                }
                else if ((bool)Harm.IsChecked)
                {
                    printout.Content = String.Join("  ", printHarm);
                }
                else if ((bool)Pent.IsChecked)
                {
                    printout.Content = String.Join("  ", printPent);
                }
                else if ((bool)Blues.IsChecked)
                {
                    printout.Content = String.Join("  ", printBlues);
                } else
                {
                    printout.Content = String.Join("  ", printMaj);
                }

            }

        
        
  
        

        private void NewWizard()
        {
            sw = new ScaleWizard();
            
        }

        public MainWindow()
        {
            InitializeComponent();
            NewWizard();

        }
    }
}
