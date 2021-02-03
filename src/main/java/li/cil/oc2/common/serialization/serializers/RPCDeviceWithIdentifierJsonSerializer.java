package li.cil.oc2.common.serialization.serializers;

import com.google.gson.*;
import li.cil.oc2.common.bus.RPCDeviceBusAdapter;

import java.lang.reflect.Type;

public final class RPCDeviceWithIdentifierJsonSerializer implements JsonSerializer<RPCDeviceBusAdapter.RPCDeviceWithIdentifier> {
    @Override
    public JsonElement serialize(final RPCDeviceBusAdapter.RPCDeviceWithIdentifier src, final Type typeOfSrc, final JsonSerializationContext context) {
        if (src == null) {
            return JsonNull.INSTANCE;
        }

        final JsonObject deviceJson = new JsonObject();
        deviceJson.add("deviceId", context.serialize(src.identifier));
        deviceJson.add("typeNames", context.serialize(src.device.getTypeNames()));

        return deviceJson;
    }
}
