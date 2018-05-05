import com.mpatric.mp3agic.Mp3File;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.File;
import java.util.ArrayList;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        ArrayList<File> files = new ArrayList<>();
        files = listf("C:\\Users\\axulina\\Desktop\\AstroSynthesisLectures", files);

        ArrayList<File> unit1Files = new ArrayList<>();
        ArrayList<File> unit2Files = new ArrayList<>();
        ArrayList<File> unit3Files = new ArrayList<>();
        ArrayList<File> unit4Files = new ArrayList<>();

        files.forEach(f -> {
            try {
                if (isUnitNo(f.getAbsolutePath(), "1")) {
                    unit1Files.add(f);
                }
                if (isUnitNo(f.getAbsolutePath(), "2")) {
                    unit2Files.add(f);
                }
                if (isUnitNo(f.getAbsolutePath(), "3")) {
                    unit3Files.add(f);
                }
                if (isUnitNo(f.getAbsolutePath(), "4")) {
                    unit4Files.add(f);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        System.out.println(unit1Files.size());
        System.out.println(unit2Files.size());
        System.out.println(unit3Files.size());
        System.out.println(unit4Files.size());

        for (int i = 0; i < unit1Files.size(); i++)
            try {
                File file = unit1Files.get(i);
                addMetadata(file.getAbsolutePath(), file.getName(), String.valueOf(i + 1));
            } catch (Exception e) {
                e.printStackTrace();
            }

        for (int i = 0; i < unit2Files.size(); i++)
            try {
                File file = unit2Files.get(i);
                addMetadata(file.getAbsolutePath(), file.getName(), String.valueOf(i + 1));
            } catch (Exception e) {
                e.printStackTrace();
            }

        for (int i = 0; i < unit3Files.size(); i++)
            try {
                File file = unit3Files.get(i);
                addMetadata(file.getAbsolutePath(), file.getName(), String.valueOf(i + 1));
            } catch (Exception e) {
                e.printStackTrace();
            }

        for (int i = 0; i < unit4Files.size(); i++)
            try {
                File file = unit4Files.get(i);
                addMetadata(file.getAbsolutePath(), file.getName(), String.valueOf(i + 1));
            } catch (Exception e) {
                e.printStackTrace();
            }

        //                moveSmallFileToSeparateFolder(f.getAbsolutePath(), f.getName());
//                scanThatAllFoldersHave2Files(f.getAbsolutePath());
//                if (f.getName().contains("01Дорожка")) {
//                if (f.getName().contains("02Дорожка")) {
//                    if (f.getName().contains("03Дорожка")) {
//                renameAndGroom(f.getAbsolutePath(), f.getName());
//                }
//                addMetadata(f.getAbsolutePath(), f.getName());

    }

    private static boolean isUnitNo(String fileLocation, String unitNo) throws Exception {
        Mp3File mp3file = new Mp3File(fileLocation);
        if (mp3file.hasId3v1Tag()) {
            return mp3file.getId3v1Tag().getAlbum().contains(unitNo);
        }
        return false;
    }

    private static void addMetadata(String fileLocation, String name, String trackNo) throws Exception {
        String unit = name.split("-")[0];
        String album = unit.substring(0, 1).toUpperCase() + unit.substring(1, unit.length() - 1).toLowerCase() + " " + unit.substring(unit.length() - 1, unit.length()).toLowerCase();

        Mp3File mp3file = new Mp3File(fileLocation);
        if (mp3file.hasId3v1Tag()) {
//            mp3file.removeId3v1Tag();
//            mp3file.getId3v1Tag().setArtist("Astro Synthesis");
//            mp3file.getId3v1Tag().setAlbum(album);
//            mp3file.getId3v1Tag().setTitle("Track " + trackNo);
//            mp3file.getId3v1Tag().setTrack(trackNo);
            mp3file.getId3v1Tag().setGenre(12);
            System.out.println("IDV1 " + ReflectionToStringBuilder.toString(mp3file.getId3v1Tag()));
        }
        if (mp3file.hasId3v2Tag()) {
//            mp3file.removeId3v2Tag();
            if (mp3file.hasId3v2Tag()) {
                mp3file.getId3v2Tag().setArtist(mp3file.getId3v1Tag().getArtist());
                mp3file.getId3v2Tag().setAlbum(mp3file.getId3v1Tag().getAlbum());
                mp3file.getId3v2Tag().setTitle(mp3file.getId3v1Tag().getTitle());
                mp3file.getId3v2Tag().setTrack(mp3file.getId3v1Tag().getTrack());
                mp3file.getId3v2Tag().setGenre(mp3file.getId3v1Tag().getGenre());
//                mp3file.getId3v2Tag().setArtist("Astro Synthesis");
//                mp3file.getId3v2Tag().setAlbum(album);
//                mp3file.getId3v2Tag().setTitle("Track " + trackNo);
//                mp3file.getId3v2Tag().setTrack(trackNo);
//                mp3file.getId3v2Tag().setGenre(12);
//                System.out.println("Track: " + id3v2Tag.getTrack());
//                System.out.println("Artist: " + id3v2Tag.getArtist());
//                System.out.println("Title: " + id3v2Tag.getTitle());
//                System.out.println("Album: " + id3v2Tag.getAlbum());
//                System.out.println("Year: " + id3v2Tag.getYear());
//                System.out.println("Genre: " + id3v2Tag.getGenre() + " (" + id3v2Tag.getGenreDescription() + ")");
//                System.out.println("Comment: " + id3v2Tag.getComment());
//                System.out.println("Lyrics: " + id3v2Tag.getLyrics());
//                System.out.println("Composer: " + id3v2Tag.getComposer());
//                System.out.println("Publisher: " + id3v2Tag.getPublishdder());
//                System.out.println("Original artist: " + id3v2Tag.getOriginalArtist());
//                System.out.println("Album artist: " + id3v2Tag.getAlbumArtist());
//                System.out.println("Copyright: " + id3v2Tag.getCopyright());
//                System.out.println("URL: " + id3v2Tag.getUrl());
//                System.out.println("Encoder: " + id3v2Tag.getEncoder());
//                byte[] albumImageData = id3v2Tag.getAlbumImage();
//                if (albumImageData != null) {
//                    System.out.println("Have album image data, length: " + albumImageData.length + " bytes");
//                    System.out.println("Album image mime type: " + id3v2Tag.getAlbumImageMimeType());
//                }
            }
//            System.out.println("IDV2 " + ReflectionToStringBuilder.toString(mp3file.getId3v2Tag()));
        }
        mp3file.save(fileLocation + "-");
        new File(fileLocation).delete();
        new File(fileLocation + "-").renameTo(new File(fileLocation));
    }

    private static void renameAndGroom(String fileLocation, String filename) throws Exception {
        Mp3File mp3file = new Mp3File(fileLocation);

//            System.out.println("Length of this mp3 is: " + mp3file.getLengthInSeconds() + " seconds");
//            System.out.println("Bitrate: " + mp3file.getBitrate() + " kbps " + (mp3file.isVbr() ? "(VBR)" : "(CBR)"));
//            System.out.println("Sample rate: " + mp3file.getSampleRate() + " Hz");
//            System.out.println("Has ID3v1 tag?: " + (mp3file.hasId3v1Tag() ? "YES" : "NO"));
//            System.out.println("Has ID3v2 tag?: " + (mp3file.hasId3v2Tag() ? "YES" : "NO"));
//            System.out.println("Has custom tag?: " + (mp3file.hasCustomTag() ? "YES" : "NO"));

        if (mp3file.hasId3v1Tag()) {
            mp3file.removeId3v1Tag();
        }
        if (mp3file.hasId3v2Tag()) {
            mp3file.removeId3v2Tag();
        }
        if (mp3file.hasCustomTag()) {
            mp3file.removeCustomTag();
        }
        String newFileName = getNewFileName(fileLocation, filename);
        System.out.println(newFileName);
        mp3file.save(newFileName);
//        new File(newFileName).delete();
    }

    private static String getNewFileName(String fileLocation, String filename) {
        String newFilename = "";
        File file = new File(fileLocation);
        String unit = file.getParentFile().getParentFile().getName();
        String tapeNo = file.getParentFile().getName().split("-")[1];
        if (tapeNo.length() == 1) tapeNo = "0" + tapeNo;


        String side = "1";
        if (filename.contains("01Дорожка 1")) {
            newFilename = getFileName(unit, tapeNo, side);
        }

        if (filename.contains("02Дорожка 2")) {
            boolean hasOneAlready = false;
            for (File fileNeibour : file.getParentFile().listFiles()) {
                if (fileNeibour.getName().contains("side1")) {
                    hasOneAlready = true;
                }
            }
            if (hasOneAlready) {
                newFilename = getFileName(unit, tapeNo, "2");
            } else {
                newFilename = getFileName(unit, tapeNo, "1");
            }
        }

        if (filename.contains("03Дорожка 3")) {
            boolean hasOneAlready = false;
            for (File fileNeibour : file.getParentFile().listFiles()) {
                if (fileNeibour.getName().contains("side1")) {
                    hasOneAlready = true;
                }
            }

            if (hasOneAlready) {
                boolean hasTwoAlready = false;
                for (File fileNeibour : file.getParentFile().listFiles()) {
                    if (fileNeibour.getName().contains("side2")) {
                        hasTwoAlready = true;
                    }
                }
                if (hasTwoAlready) {
                    newFilename = getFileName(unit, tapeNo, "3");
                } else {
                    newFilename = getFileName(unit, tapeNo, "2");
                }
            } else {
                newFilename = getFileName(unit, tapeNo, "1");
            }
        }

        return file.getParentFile().getAbsolutePath() + "\\" + newFilename;
    }

    private static void moveSmallFileToSeparateFolder(String fileLocation, String filename) throws Exception {
        Mp3File mp3file = new Mp3File(fileLocation);
        if (mp3file.getLengthInSeconds() < 300) {
            File file = new File(fileLocation);
            String newpath = "C:\\Users\\axulina\\Desktop\\tocheck\\" + file.getParentFile().getName() + " " + filename;
            System.out.println(newpath);
            System.out.println(file.renameTo(new File(newpath)));
        }
    }

    private static void scanThatAllFoldersHave2Files(String fileLocation) throws Exception {//double work
        File file = new File(fileLocation);
        File[] files = file.getParentFile().listFiles();
        if (/*files.length > 2 || */files.length < 2) {
            System.out.println(file.getParentFile().getAbsolutePath());
        }
    }


    private static String getFileName(String unit, String tapeNo, String side) {
        return unit.replaceAll(" ", "") + "-tape" + tapeNo + "-side" + side + ".mp3";
    }


    /*    //        String fileLocation = "G:/asas/album/song.mp3";
        try {
            InputStream input = new FileInputStream(new File(fileLocation));
            ContentHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new Mp3Parser();
            ParseContext parseCtx = new ParseContext();
            parser.parse(input, handler, metadata, parseCtx);
            input.close();

            // List all metadata
            String[] metadataNames = metadata.names();

            for (String name : metadataNames) {
                System.out.println(name + ": " + metadata.get(name));
            }

            // Retrieve the necessary info from metadata
            // Names - title, xmpDM:artist etc. - mentioned below may differ based
            System.out.println("----------------------------------------------");
            System.out.println("Title: " + metadata.get("title"));
            System.out.println("Artists: " + metadata.get("xmpDM:artist"));
            System.out.println("Composer : " + metadata.get("xmpDM:composer"));
            System.out.println("Genre : " + metadata.get("xmpDM:genre"));
            System.out.println("Album : " + metadata.get("xmpDM:album"));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        }
    }*/

    private static ArrayList<File> listf(String directoryName, ArrayList<File> files) {
        File directory = new File(directoryName);

        // get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                if (file.getName().contains(".mp3")) {
                    files.add(file);
                }
            } else if (file.isDirectory()) {
                listf(file.getAbsolutePath(), files);
            }
        }
        return files;
    }
}