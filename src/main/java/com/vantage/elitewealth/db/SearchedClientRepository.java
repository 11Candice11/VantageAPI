package com.vantage.elitewealth.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchedClientRepository extends JpaRepository<SearchedClient, Long> {

    /** Most recently searched clients, deduped by entity ID */
    @Query("""
        SELECT s FROM SearchedClient s
        WHERE s.searchedAt = (
            SELECT MAX(s2.searchedAt) FROM SearchedClient s2
            WHERE s2.entityId = s.entityId
        )
        ORDER BY s.searchedAt DESC
        """)
    List<SearchedClient> findLatestPerEntity();

    boolean existsByEntityId(String entityId);

    List<SearchedClient> findTop20ByOrderBySearchedAtDesc();
}
