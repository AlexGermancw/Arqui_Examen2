package ec.edu.espe.pruebaparcial2chicaiza.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "clients")
@CompoundIndexes({
        @CompoundIndex(name = "idxu_clients_id", def = "{'identificationType': 1, 'identification': 1}", unique = true)
})
public class User {
    @Id
    private String id;

    @Indexed
    private String lastname;
    private String firstname;
    /*
     * private List<ClientRelationship> relationship;
     * private List<ClientReference> reference;
     * private List<ClientPhone> phone;
     * private List<ClientAddress> address;
     */
    @Version
    private Number version;
}
