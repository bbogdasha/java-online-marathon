package com.bogdan.service;

import com.bogdan.model.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ClientServiceImpl implements ClientService {

    private static final Map<Integer, Client> CLIENT_REPOSITORY = new HashMap<>();
    private static final AtomicInteger CLIENT_ID = new AtomicInteger();

    @Override
    public void create(Client client) {
        final int clientId = CLIENT_ID.incrementAndGet();
        client.setId(clientId);
        CLIENT_REPOSITORY.put(clientId, client);
    }

    @Override
    public List<Client> readAll() {
        return new ArrayList<>(CLIENT_REPOSITORY.values());
    }

    @Override
    public Client read(int id) {
        return CLIENT_REPOSITORY.get(id);
    }

    @Override
    public boolean update(Client client, int id) {
        if (CLIENT_REPOSITORY.containsKey(id)) {
            client.setId(id);
            CLIENT_REPOSITORY.put(id, client);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return CLIENT_REPOSITORY.remove(id) != null;
    }
}
