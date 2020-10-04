package restoamar.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Table("asset")
public class Asset implements Serializable {

    private static final long serialVersionUID = 1L;

    @PrimaryKey
    private UUID id;

    private String name;

    private String description;

    private String location;

    public Asset() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Asset(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(UUID assetid) {
        this.id = assetid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asset asset = (Asset) o;
        return Objects.equals(id, asset.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}