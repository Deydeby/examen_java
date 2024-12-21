package com.exemple.repository;

import com.exemple.entity.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {
    Client findByTelephone(String telephone);
}
