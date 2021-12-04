@GenericGenerator(
    name = "optimized-sequence",
    strategy = "enhanced-sequence",
    parameters = {
      @Parameter(
          name = org.hibernate.id.enhanced.SequenceStyleGenerator.CONFIG_PREFER_SEQUENCE_PER_ENTITY,
          value = "true"),
      @Parameter(name = org.hibernate.id.enhanced.SequenceStyleGenerator.OPT_PARAM, value = "hilo")
    })
package ch.mike.goetz.iaap.server.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
