package com.vantage.elitewealth.db;

import jakarta.persistence.*;
import java.time.Instant;

/**
 * Persists every client that has been searched or viewed in the UI.
 * Stored in the local H2 database so the advisor can see their search history.
 */
@Entity
@Table(name = "searched_clients")
public class SearchedClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** EliteWealth entity ID (UUID string) */
    @Column(name = "entity_id", nullable = false)
    private String entityId;

    @Column(name = "entity_name")
    private String entityName;

    @Column(name = "first_names")
    private String firstNames;

    @Column(name = "surname")
    private String surname;

    @Column(name = "id_number")
    private String idNumber;

    @Column(name = "entity_type")
    private String entityType;

    @Column(name = "preferred_email")
    private String preferredEmail;

    @Column(name = "search_query")
    private String searchQuery;

    @Column(name = "searched_at", nullable = false)
    private Instant searchedAt;

    public SearchedClient() {}

    public SearchedClient(String entityId, String entityName, String firstNames, String surname,
                          String idNumber, String entityType, String preferredEmail, String searchQuery) {
        this.entityId      = entityId;
        this.entityName    = entityName;
        this.firstNames    = firstNames;
        this.surname       = surname;
        this.idNumber      = idNumber;
        this.entityType    = entityType;
        this.preferredEmail = preferredEmail;
        this.searchQuery   = searchQuery;
        this.searchedAt    = Instant.now();
    }

    public Long getId()                  { return id; }
    public String getEntityId()          { return entityId; }
    public String getEntityName()        { return entityName; }
    public String getFirstNames()        { return firstNames; }
    public String getSurname()           { return surname; }
    public String getIdNumber()          { return idNumber; }
    public String getEntityType()        { return entityType; }
    public String getPreferredEmail()    { return preferredEmail; }
    public String getSearchQuery()       { return searchQuery; }
    public Instant getSearchedAt()       { return searchedAt; }

    public void setSearchedAt(Instant searchedAt) { this.searchedAt = searchedAt; }
}
