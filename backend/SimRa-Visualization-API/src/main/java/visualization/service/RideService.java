package visualization.service;

import org.springframework.data.mongodb.core.geo.GeoJsonGeometryCollection;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import visualization.web.resources.RideResource;

import java.util.List;

public interface RideService {

    List<RideResource> getRidesInRange(double latitude, double longitude, int maxDistance);

    RideResource getRideById(String rideId);

    List<RideResource> getRidesWithin(GeoJsonPoint first, GeoJsonPoint second, GeoJsonPoint third, GeoJsonPoint fourth);

    GeoJsonGeometryCollection getRidesMapMatchedInRange(double longitude, double latitude, int maxDistance);
}
