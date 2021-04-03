package jm.springtoy.urlshortener.repository;

import jm.springtoy.urlshortener.domain.ShortURL;

import java.util.List;
import java.util.Optional;

public interface ShortURLRepository {
    ShortURL save(ShortURL url);
    Optional<ShortURL> findById(String id);
    Optional<ShortURL> findByUrl(String url);
    List<ShortURL> findAll();
}
