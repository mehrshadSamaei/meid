package song;

import java.util.*;

public class ApplicationMainMedia {
    private static ArrayList<Album> arrayList = new ArrayList<>();

    public static void main(String[] args) {


        Album album = new Album("Albome1", "salar Aghili");
        album.addSong("Iran", 3.5);
        album.addSong("angor", 5);
        album.addSong("vatan", 2);
        album.addSong("hamasi", 1);
        album = new Album("album2", "horoshBand");
        album.addSong("ba angosht", 3);
        album.addSong("afsane", 2);

        arrayList.add(album);

        LinkedList<Song> playList1 = new LinkedList<>();
        arrayList.get(0).addToPlayList("iran", playList1);
        arrayList.get(0).addToPlayList("angor", playList1);
//        arrayList.get(1).addToPlayList("horoshBand", playList1);

        play(playList1);
    }

    private static void play(LinkedList<Song> playList1) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList1.listIterator();
        if (playList1.size() == 0) {
            System.out.println("this playList have no song");
        } else {
            System.out.println("now play list" + listIterator.toString());
            printMenu();
        }
        printMenu();
        while (!quit) {
            int action = sc.nextInt();

            sc.nextLine();

            switch (action) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) ;
                    }
                    forward = true;
                    if (listIterator.hasNext()) {
                        System.out.println("now play" + listIterator.next().toString());
                    } else {
                        System.out.println("this not have ");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println(listIterator.previous().toString());
                        } else
                            System.out.println("this first song");
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println(listIterator.previous().toString());
                            forward = false;
                        } else
                            System.out.println("se are at the start list");
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("now playing " + listIterator.next().toString());
                        } else
                            System.out.println("we have reached the end of list");
                    }
                    break;

                case 4:
                    printList(playList1);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList1.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("now playing" + listIterator.next().toString());
                            forward = true;
                        } else {
                            if (listIterator.hasPrevious()) {
                                System.out.println("now playing" + listIterator.previous().toString());
                            }
                        }
                    }
            }
        }
    }

    private static void printMenu() {
        System.out.println("avilable option press");
        System.out.println("0 - quit ,1 next musick , 2 previus musick , 3 reply , 4 list  , 5 " +
                "avalaible option , 6 delete current song");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> it = playList.listIterator();
        System.out.println("---------");

        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("------");

    }
}
