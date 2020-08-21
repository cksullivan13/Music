using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;

namespace Music_Theory_Desktop
{
    class ScaleWizard
    {
        private String[] keyboard = { "C", "C#/Db", "D", "D#/Eb", "E", "F", "F#/Gb", "G", "G#/Ab", "A", "A#/Bb", "B", "C",
            "C#/Db", "D", "D#/Eb", "E", "F", "F#/Gb", "G", "G#/Ab", "A", "A#/Bb", "B", "C" };

        #region Converter
        public int InputConverter(Button button)
		{
			
			int converted = 0;

			if ((string)button.Content == "C")
			{
				converted = 0;
			}
			else if ((string)button.Content == "C#/Db")
			{
				converted = 1;
			}
			else if ((string)button.Content == "D")
			{
				converted = 2;

			}
			else if ((string)button.Content == "D#/Eb")
			{
				converted = 3;

			}
			else if ((string)button.Content == "E")
			{
				converted = 4;

			}
			else if ((string)button.Content == "F")
			{
				converted = 5;

			}
			else if ((string)button.Content == "F#/Gb")
			{
				converted = 6;

			}
			else if ((string)button.Content == "G")
			{
				converted = 7;
				
			}
			else if ((string)button.Content == "G#/Ab")
			{
				converted = 8;

			}
			else if ((string)button.Content == "A")
			{
				converted = 9;

			}
			else if ((string)button.Content == "A#/Bb")
			{
				converted = 10;

			}
			else if ((string)button.Content == "B")
			{
				converted = 11;

			}
			return converted;
		}

        #endregion




        public String[] RotateLeft(String[] keyboard, int converted)
		{
			int i = 0;
			int targetScaleSpot = converted;
			String[] rotated = new String[keyboard.Length];

			while (targetScaleSpot < keyboard.Length)
			{
				rotated[i] = keyboard[targetScaleSpot];
				i++;
				targetScaleSpot++;
			}
			targetScaleSpot = 0;
			while (i < keyboard.Length)
			{
				rotated[i] = keyboard[targetScaleSpot];
				i++;
				targetScaleSpot++;
			}
			return rotated;

        }


        #region Scale Methods
        public String[] MakeMajor(String[] rotated)
		{
			String[] scaleToPrint = new String[8];
			int count = 0;

			for (int i = 0; i < rotated.Length; i++)
			{
				if (i == 0 || i == 2 || i == 4 || i == 5 || i == 7 || i == 9 || i == 11 || i == 12)
				{
					scaleToPrint[count] = rotated[i];
					count++;

				}
			}
			return scaleToPrint;
		}

		public String[] MakeMinor(String[] rotated)
		{
			String[] minorPrint = new String[8];
			int count = 0;

			for (int i = 0; i < rotated.Length; i++)
			{
				if (i == 0 || i == 2 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12)
				{
					minorPrint[count] = rotated[i];
					count++;
				}
			}
			return minorPrint;
		}

		public String[] MakeHarmonic(String[] rotated)
		{
			String[] harmoPrint = new String[8];
			int count = 0;

			for (int i = 0; i < rotated.Length; i++)
			{
				if (i == 0 || i == 2 || i == 3 || i == 5 || i == 7 || i == 8 || i == 11 || i == 12)
				{
					harmoPrint[count] = rotated[i];
					count++;
				}
			}
			return harmoPrint;

		}

		public String[] MakePent(String[] rotated)
		{
			String[] pentPrint = new String[5];
			int count = 0;

			for (int i = 0; i < rotated.Length; i++)
			{
				if (i == 0 || i == 4 || i == 7 || i == 11 || i == 12)
				{
					pentPrint[count] = rotated[i];
					count++;
				}
			}
			return pentPrint;
		}

		public String[] MakeBlues(String[] rotated)
		{
			String[] bluesPrint = new String[7];
			int count = 0;

			for (int i = 0; i < rotated.Length; i++)
			{
				if (i == 0 || i == 3 || i == 5 || i == 6 || i == 7 || i == 10 || i == 12)
				{
					bluesPrint[count] = rotated[i];
					count++;
				}
			}
			return bluesPrint;
		}
        #endregion

        public String[] GetKeyboard()
		{
			return keyboard;
		}

		public void SetKeyboard(String[] keyboard)
		{
			this.keyboard = keyboard;
		}



	}
}
