package jm.springtoy.urlshortener.repository;

import jm.springtoy.urlshortener.domain.ShortURL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaShortURLRepository extends JpaRepository<ShortURL, String>, ShortURLRepository{
    @Override
    public Optional<ShortURL> findByUrl(String url);
}
