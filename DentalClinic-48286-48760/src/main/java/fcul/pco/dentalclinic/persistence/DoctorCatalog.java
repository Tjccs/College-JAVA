package fcul.pco.dentalclinic.persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import fcul.pco.dentalclinic.domain.Doctor;
import fcul.pco.dentalclinic.domain.Patient;
import fcul.pco.dentalclinic.main.ApplicationConfiguration;

public class DoctorCatalog {

	
	public static void save(Map<Integer, Doctor> doctors) throws IOException{
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(ApplicationConfiguration.ROOT_DIRECTORY
                + "/"
                + ApplicationConfiguration.DOCTOR_CATALOG_FILENAME))) {
            for (Doctor d : doctors.values()) {
                bw.write(d.toString());
                bw.newLine();
            }
        }
    }

	public static Map<Integer,Doctor> load() throws FileNotFoundException {
		Map<Integer, Doctor> doctors = new TreeMap<>();
        try (Scanner br = new Scanner(new FileReader(ApplicationConfiguration.ROOT_DIRECTORY
                + "/"
                + ApplicationConfiguration.DOCTOR_CATALOG_FILENAME))) {
            while (br.hasNextLine()) {
                Doctor d = Doctor.fromString(br.nextLine());
                doctors.put(d.getId(), d);
            }
        } catch (FileNotFoundException ex) {
            // if the file is not found return the empty catalog.
        }
        return doctors;
	}

}

