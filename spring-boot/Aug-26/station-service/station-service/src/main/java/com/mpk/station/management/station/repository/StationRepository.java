package com.mpk.station.management.station.repository;

import com.mpk.station.management.station.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StationRepository extends JpaRepository<Station, UUID> {

}
