package pl.wsb.restexample.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wsb.restexample.exceeptions.ResourceNotFoundException;
import pl.wsb.restexample.models.WonderOfTheWorld;
import pl.wsb.restexample.models.WonderOfTheWorldDto;
import pl.wsb.restexample.repositories.WonderOfTheWorldRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class WonderOfTheWorldService {

    private final WonderOfTheWorldRepository wonderOfTheWorldRepository;

    public List<WonderOfTheWorld> getAll() {
        return wonderOfTheWorldRepository.getAll();
    }

    public WonderOfTheWorld get(Long id) {
        return wonderOfTheWorldRepository
                .get(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public WonderOfTheWorld create(WonderOfTheWorldDto wonderOfTheWorldDto){
        return wonderOfTheWorldRepository.create(wonderOfTheWorldDto);
    }

    public WonderOfTheWorld update(Long id, WonderOfTheWorldDto wonderOfTheWorldDto) {
        WonderOfTheWorld wonderOfTheWorld = get(id);
        return wonderOfTheWorldRepository.update(wonderOfTheWorld, wonderOfTheWorldDto);
    }

    public void delete(Long id){
        WonderOfTheWorld wonderOfTheWorld = get(id);
        wonderOfTheWorldRepository.delete(wonderOfTheWorld);
    }
}
