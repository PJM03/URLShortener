package jm.springtoy.urlshortener.repository;

import jm.springtoy.urlshortener.domain.ShortURL;

import java.util.*;

public class MemoryShortURLRepository implements ShortURLRepository{

    private static Map<String, ShortURL> store = new HashMap<>();

    @Override
    public ShortURL save(ShortURL url) {
        store.put(url.getId(), url);
        return url;
    }

    @Override
    public Optional<ShortURL> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<ShortURL> findByUrl(String url) {
        return store.values().stream()
                .filter(shortURL -> shortURL.getUrl().equals(url))
                .findAny();
    }

    @Override
    public List<ShortURL> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
