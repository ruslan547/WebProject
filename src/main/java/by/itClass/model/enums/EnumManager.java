package by.itClass.model.enums;

import by.itClass.model.exceptions.ServiceException;

public final class EnumManager {
    public static SectionMenu getKindSectionMenu(String sect) throws ServiceException {
        try {
            return SectionMenu.valueOf(sect.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ServiceException(e);
        }
    }
}
