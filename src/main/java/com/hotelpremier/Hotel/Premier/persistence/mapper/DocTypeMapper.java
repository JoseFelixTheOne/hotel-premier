package com.hotelpremier.Hotel.Premier.persistence.mapper;

import com.hotelpremier.Hotel.Premier.domain.DocType;
import com.hotelpremier.Hotel.Premier.persistence.entity.TipoDocumento;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DocTypeMapper {
    @Mapping(source = "idTipoDoc", target = "idTypeDoc")
    @Mapping(source = "descripcion", target = "desc")
    DocType toDocType(TipoDocumento tipoDocumento);
    List<DocType> toDocTypes(List<TipoDocumento> tipoDocumentos);

    @InheritInverseConfiguration
    TipoDocumento toTipoDocumento(DocType docType);
}
