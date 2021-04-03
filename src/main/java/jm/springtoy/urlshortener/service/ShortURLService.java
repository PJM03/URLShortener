package jm.springtoy.urlshortener.service;

import jm.springtoy.urlshortener.Util;
import jm.springtoy.urlshortener.domain.ShortURL;
import jm.springtoy.urlshortener.repository.ShortURLRepository;
import jm.springtoy.urlshortener.repository.SpringDataJpaShortURLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.MessageDigest;
import java.util.List;

@Transactional
@Service
public class ShortURLService {
    private ShortURLRepository repository;

    @Autowired
    public ShortURLService(SpringDataJpaShortURLRepository repository) {
        this.repository = repository;
    }

    public ShortURL save(String id, String url, String password) {
        ShortURL sUrl = new ShortURL(id, url, Util.encrypt("SHA-256", password));
        return repository.save(sUrl);
    }

    public ShortURL save(ShortURL sUrl) {
        return repository.save(sUrl);
    }

    public ShortURL findById(String id) {
        return repository.findById(id).orElse(new ShortURL("", "/", ""));
    }

    public List<ShortURL> findAll() {
        return repository.findAll();
    }
}
