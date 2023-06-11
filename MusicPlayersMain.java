package music_players_jdbc.app;

import java.util.Scanner;

public class MusicPlayersMain {

	public static void main(String[] args) throws Exception {
		try (Scanner scanner = new Scanner(System.in)) {
			MusicCrud crud = new MusicCrud();
			MusicCrud music = new MusicCrud();
			boolean flag = true;
			do {

				System.out.println(
						"Enter The Choice \n1. Save Music \n2. Update Music \n3. Delete Music \n4. getMusicById \n5. getAllMusics \n6. Play Music. \n7.Exit Application.");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1: {
					System.out.println("Enter a Id :");
					int id = scanner.nextInt();
					System.out.println("Enter a Name :");
					String name = scanner.next();
					System.out.println("Enter a Singure :");
					String singure = scanner.next();
					System.out.println("Enter a Language :");
					String language = scanner.next();
					music.setId(id);
					music.setName(name);
					music.setSingure(singure);
					music.setLanguage(language);
					crud.saveMusic(music);
				}
					break;
				case 2: {
					System.out.println("Enter a Id :");
					int id = scanner.nextInt();

					System.out.println("Enter a New Name : ");
					String Name = scanner.next();
					System.out.println("Enter a Singure :");
					String singure = scanner.next();
					System.out.println("Enter a Language :");
					String language = scanner.next();
					music.setId(id);
					music.setName(Name);
					music.setSingure(singure);
					music.setLanguage(language);
					crud.updateMusicapp(music);
				}
					break;
				case 3: {
					System.out.println("Enter a Id :");
					int id = scanner.nextInt();
					music.setId(id);
					crud.deleteMusicapp(music);
				}
					break;
				case 4: {
					System.out.println("Enter a Id :");
					int id = scanner.nextInt();
					crud.getMusicappById(id);
				}
					break;
				case 5: {
					crud.fetchMusicapp(music);
				}
					break;
				case 6: {
					System.out.println("Enter a Id : ");
					int id = scanner.nextInt();
					music.setId(id);

					crud.playmusic(music);
				}
				case 7: {
					flag = false;
				}

				default:
					flag = false;
					break;
				}
			} while (flag);
		}
	}
}
