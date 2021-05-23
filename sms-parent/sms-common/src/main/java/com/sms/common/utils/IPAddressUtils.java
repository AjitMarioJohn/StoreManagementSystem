package com.sms.common.utils;

import com.sms.common.models.IPAddressModel;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;
import java.util.function.Function;

public class IPAddressUtils {

    public static IPAddressModel getIpDetails() throws UnknownHostException {
        return Optional.ofNullable(InetAddress.getLocalHost()).map(convertIpDetails).orElse(new IPAddressModel());
    }

    private static final Function<InetAddress, IPAddressModel> convertIpDetails = (inetAddress) -> {
        final IPAddressModel ipAddressModel = new IPAddressModel();
        ipAddressModel.setHostName(inetAddress.getHostName().trim());
        ipAddressModel.setHostAddress(inetAddress.getHostAddress().trim());
        return ipAddressModel;
    };

}
