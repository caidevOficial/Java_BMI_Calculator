/*
 * Copyright (C) 2020 <FacuFalcone - CaidevOficial>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package Logic;

import java.net.URL;
import java.text.DecimalFormat;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import GUI.Imc_gui;

/**
 * @author CaidevOficial
 */
public class Main {

    /**
     * Replaces the Space.
     * @param thisString String to replace the comma.
     * @return The string with a space replaced.
     */
    public static String CheckSpace(String thisString) {
	return thisString.replace(" ", "");
    }

    /**
     * Calculates the IMC.
     * @param height Height of the person.
     * @param weigth Weight of the person.
     * @return the IMC if all the values are ok, otherwise returns 0.
     */
    public static double calculateIMC(double height, double weigth) {
	if (height > 0) {
	    DecimalFormat df = new DecimalFormat("#,###.00");
	    @SuppressWarnings("deprecation")
	    double imc = new Double(df.format(((weigth) / Math.pow(height, 2)))).doubleValue();
	    return imc;
	}

	return 0;
    }

    /**
     * Plays a Background music.
     */
    public static void backgroundMusic(String songAndExtension) {
	try {
	    URL is = ClassLoader.getSystemResource(songAndExtension);
	    AudioInputStream audioIn = AudioSystem.getAudioInputStream(is);
	    Clip thisSound = AudioSystem.getClip();
	    thisSound.open(audioIn);
	    thisSound.start();
	    while (thisSound.isRunning()) {
		Thread.sleep(1000);
	    }
	    thisSound.loop(Clip.LOOP_CONTINUOUSLY);
	} catch (Exception e) {
	    // TODO: handle exception
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

	Imc_gui imcApp = new Imc_gui();
	//backgroundMusic("Media/Blinding_Lights_Jap.wav");
	imcApp.setVisible(true);
	imcApp.setLocationRelativeTo(null);
    }
}
