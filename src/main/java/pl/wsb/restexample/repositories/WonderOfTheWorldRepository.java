package pl.wsb.restexample.repositories;

import org.springframework.stereotype.Repository;
import pl.wsb.restexample.models.WonderOfTheWorld;
import pl.wsb.restexample.models.WonderOfTheWorldDto;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class WonderOfTheWorldRepository {

    static Long currentId = 11L;

    static final List<WonderOfTheWorld> wonders = new LinkedList<>(Arrays.asList(
            new WonderOfTheWorld(1L, "Piramida Cheopsa", "2575 p.n.e.", "Egipt, Giza",
                            "Siedem cudow starozytnego swiata", "Zbudowana z przeznaczeniem na grobowiec faraona Cheopsa."),
            new WonderOfTheWorld(2L, "Wiszące ogrody Semiramidy", "600 p.n.e.", "Mezopotamia, Babilon",
                            "Siedem cudow starozytnego swiata", "Zbudowane na polecenie króla Nabuchodonozora II, który podarował je swojej żonie, Amytis."),
            new WonderOfTheWorld(3L, "Posąg Zeusa ", "435-430 p.n.e.", "Grecja, Olimpia",
                            "Siedem cudow starozytnego swiata", "Rzeźba przedstawiała siedzącego na tronie Zeusa o poważnym i dostojnym obliczu."),
            new WonderOfTheWorld(4L, "Kanał Panamski", "1904–1914", "Panama",
                            "Cuda współczesnego świata, Przemysłowe cuda", "Sztuczny kanał wodny długości ponad 80 km łączący wody Oceanu Atlantyckiego z wodami Oceanu Spokojnego"),
            new WonderOfTheWorld(5L, "Golden Gate Bridge", "27 maja 1937", "Stany Zjednoczone, San Francisco",
                            "Cuda współczesnego świata", "Most wiszący łączący San Francisco z hrabstwem Marin, nad cieśniną Golden Gate."),
            new WonderOfTheWorld(6L, "Machu Picchu", "1438–1471", "Peru",
                            "Cuda turystycznych podróży, Nowe Siedem Cudów", "Najlepiej zachowane miasto Inków"),
            new WonderOfTheWorld(7L, "Wielki Mur Chiński", "III wiek p.n.e.", "Chinska Republika Ludowa",
                            "Cuda turystycznych podróży, Nowe Siedem Cudów", "System obronny składający się z zapór naturalnych, sieci fortów, wież obserwacyjnych oraz murów obronnych z ubitej ziemi"),
            new WonderOfTheWorld(8L, "Wielki Kanion Kolorado", "17 mln lat temu", "Stany Zjednoczone, Arizona",
                            "Cuda turystycznych podróży, Cuda natury", "W kanionie tym można dostrzec przekrój geologiczny od proterozoiku (w prekambrze) po trias (era mezozoiczna)."),
            new WonderOfTheWorld(9L, "Bajkal", "25 mln lat temu", "Rosja",
                            "Podwodne cuda", "Jest najstarszym i najgłębszym jeziorem na świecie."),
            new WonderOfTheWorld(10L, "Zapora Hoovera", "1936", "Stany Zjednoczone, Kolorado",
                            "Przemysłowe cuda", "Betonowa zapora wodna typu grawitacyjno-łukowego.")
    ));

    public List<WonderOfTheWorld> getAll(){
        return wonders;
    }

    public Optional<WonderOfTheWorld> get(Long id){
        return wonders.stream()
                .filter(wonder -> wonder.getId().equals(id))
                .findFirst();
    }

    public WonderOfTheWorld create(WonderOfTheWorldDto wonderOfTheWorldDto) {
        WonderOfTheWorld newWonder = new WonderOfTheWorld(currentId, wonderOfTheWorldDto);
        wonders.add(newWonder);
        currentId++;
        return newWonder;
    }

    public WonderOfTheWorld update(WonderOfTheWorld wonder, WonderOfTheWorldDto wonderOfTheWorldDto) {
        wonder.setName(wonderOfTheWorldDto.getName());
        wonder.setDate(wonderOfTheWorldDto.getDate());
        wonder.setLocation(wonderOfTheWorldDto.getLocation());
        wonder.setType(wonderOfTheWorldDto.getType());
        wonder.setDescription(wonderOfTheWorldDto.getDescription());
        return wonder;
    }

    public void delete(WonderOfTheWorld wonderOfTheWorld) {
        wonders.remove(wonderOfTheWorld);
    }
}
