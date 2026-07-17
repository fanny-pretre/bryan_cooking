import { Box, Button, Stack, Typography } from "@mui/material";
import { Link } from "react-router-dom";

import RestaurantMenuIcon from "@mui/icons-material/RestaurantMenu";
import AddShoppingCartIcon from "@mui/icons-material/AddShoppingCart";
import CalendarMonthIcon from "@mui/icons-material/CalendarMonth";

const QuickLinks = () => {
  const links = [
    {
      label: "Ajouter une nouvelle recette",
      path: "/meal/add",
      icon: <RestaurantMenuIcon />,
    },
    {
      label: "Ajouter un nouvel ingrédient",
      path: "/ingredient/add",
      icon: <AddShoppingCartIcon />,
    },
    {
      label: "Planifier et organiser les menus",
      path: "/planning",
      icon: <CalendarMonthIcon />,
    },
  ];

  return (
    <Box
      sx={{
        width: "100%",
        mt: 3,
      }}
    >
      <Typography
        variant="h6"
        sx={{
          fontWeight: 600,
          mb: 2,
        }}
      >
        Accès rapides
      </Typography>

      <Stack
        spacing={2}
        direction={{
          xs: "column",
          sm: "row",
        }}
      >
        {links.map((link) => (
          <Button
            key={link.path}
            variant="contained"
            component={Link}
            to={link.path}
            startIcon={link.icon}
            sx={{
              flex: 1,
              minHeight: 120,
              borderRadius: 2,

              flexDirection: {
                xs: "row",
                sm: "column",
              },

              gap: {
                xs: 1,
                sm: 2,
              },

              py: 2,

              "& .MuiButton-startIcon": {
                margin: {
                  xs: 0,
                  sm: 0,
                },

                "& svg": {
                  fontSize: {
                    xs: 28,
                    sm: 45,
                  },
                },
              },
            }}
          >
            {link.label}
          </Button>
        ))}
      </Stack>
    </Box>
  );
};

export default QuickLinks;
