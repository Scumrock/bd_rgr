package edu.mkorepanov.command;

import edu.mkorepanov.command.commands.*;

public enum CommandEnum {

    ADD_NEW_AGENCY_COMMAND(new AddNewAgencyCommand()),
    DELETE_AGENCY_COMMAND(new DeleteAgencyCommand()),
    FIND_ALL_BY_AGENCY_NAME_COMMAND(new FindAllByAgencyNameCommand()),
    FIND_ALL_BY_AGENCY_ADDRESS_COMMAND(new FindAllByAgencyAddressCommand()),
    GET_ALL_AGENCY_COMMAND(new GetAllAgencyCommand()),

    ADD_NEW_CLIENT_COMMAND(new AddNewClientCommand()),
    GET_CLIENT_BY_PASSPORT_COMMAND(new GetClientByPassportCommand()),
    DELETE_CLIENT_BY_PASSPORT_COMMAND(new DeleteClientByPassportCommand()),
    GET_ALL_CLIENT_ORDERS_COMMAND(new GetALLClientOrdersCommand()),
    GET_ALL_CLIENTS_COMMAND(new GetAllClientsCommand()),
    UPDATE_CLIENT_BY_PASSPORT_COMMAND(new UpdateClientByPassportCommand()),

    ADD_NEW_SIGHTS_COMMAND(new AddNewSightsCommand()),
    GET_SIGHTS_BY_LONGITUDE_AND_LATITUDE_COMMAND(new GetSightsByLongitudeAndLatitudeCommand()),
    DELETE_SIGHTS_BY_LONGITUDE_AND_LATITUDE_COMMAND(new DeleteSightsByLongitudeAndLatitudeCommand()),
    GET_ALL_SIGHTS_EXCURSION_COMMAND(new GetALLSightsExcursionCommand()),
    GET_ALL_SIGHTS_COMMAND(new GetAllSightsCommand()),

    ADD_NEW_TOUR_COMMAND(new AddNewTourCommand()),
    GET_TOUR_BY_NAME_DEPARTURE_AND_AGENCY_TO_WHICH_BELONGS_COMMAND(new GetTourByNameDepartureAndAgencyToWhichBelongsCommand()),
    DELETE_TOUR_BY_NAME_DEPARTURE_AND_AGENCY_TO_WHICH_BELONGS_COMMAND(new DeleteTourByNameDepartureAndAgencyToWhichBelongsCommand()),
    UPDATE_TOUR_BY_NAME_DEPARTURE_AND_AGENCY_TO_WHICH_BELONGS(new UpdateTourByNameDepartureAndAgencyToWhichBelongsCommand()),
    GET_ALL_TOURS_COMMAND(new GetAllToursCommand()),

    ADD_NEW_ORDER_COMMAND(new AddNewOrderCommand()),
    DELETE_ORDER_BY_METADATA_COMMAND(new DeleteOrderByMetadataCommand()),
    GET_ALL_ORDERS_COMMAND(new GetAllOrdersCommand()),

    ADD_NEW_EXCURSION_COMMAND(new AddNewExcursionCommand()),
    DELETE_EXCURSION_BY_METADATA_COMMAND(new DeleteExcursionByMetadataCommand()),
    GET_ALL_EXCURSIONS_COMMAND(new GetAllExcursionsCommand());

    private final Command command;

    CommandEnum(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
